import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ClosestPair {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            Integer n = sc.nextInt();
            if(n==0) break;
            ArrayList<Point> coordinates = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Point p = new Point(sc.nextDouble(),sc.nextDouble());
                coordinates.add(p);
            }
            double ans = closetPair(coordinates);
            if (ans > 10000){
                System.out.println("INFINITY");
            }
            else{
                System.out.printf("%.4f\n", ans);
            }
        }
    }
    static class Point {
        final double x;
        final double y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }
    static double distance(Point x1, Point x2){
        return Math.sqrt( Math.pow((x1.x - x2.x), 2) + Math.pow((x1.y - x2.y),2) );
    }
    static double bruteForce(ArrayList<Point> P){
        double min = Double.MAX_VALUE;
        for(int i = 0; i < P.size(); i++){
            for (int j = i+1; j < P.size(); j++) {
                double pointdist = distance(P.get(i),P.get(j));
                if(pointdist < min){
                    min = pointdist;
                }
            }
        }
        return min;
    }
    public static double closetPair(ArrayList<Point> P){

        ArrayList<Point> Px = new ArrayList<>(P);
        ArrayList<Point> Py = new ArrayList<>(P);

        Collections.sort(Px, new SortbyX());
        Collections.sort(Py, new SortbyY());

        return helper(Px, Py);
    }
    static class SortbyX implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.x - b.x < 0)
                return -1;
            else if (a.x - b.x == 0)
                return 0;
            else
                return 1;
        }
    }
    static class SortbyY implements Comparator<Point>{
        public int compare(Point a, Point b) {
            if (a.y - b.y < 0)
                return -1;
            else if (a.y - b.y == 0)
                return 0;
            else
                return 1;
        }
    }
    static double helper(ArrayList<Point> px, ArrayList<Point> py){
        if(px.size()<=3) return bruteForce(px);
        int mid = px.size()/2;
        Point midPoint = px.get(mid);
        ArrayList<Point> xl = new ArrayList<>(px.subList(0,mid));
        ArrayList<Point> xr = new ArrayList<>(px.subList(mid,px.size()));
        ArrayList<Point> yl = new ArrayList<>();
        ArrayList<Point> yr = new ArrayList<>();
        for (int i = 0; i < py.size(); i++) {
            Point toadd = py.get(i);
            if (py.get(i).x <= midPoint.x)
                yl.add(toadd);
            else
                yr.add(toadd);
        }
        double ansl = helper(xl, yl);
        double ansr = helper(xr, yr);

        double newMin = Math.min(ansl,ansr);

        ArrayList<Point> line = new ArrayList<>();
        for (int i = 0; i < py.size() ; i++) {
            Point addToLine = py.get(i);
            if(Math.abs(addToLine.x - midPoint.x) < newMin){
                line.add(addToLine);
            }
        }
        return Math.min(newMin, lineHelper(line, newMin));
    }
    public static double lineHelper(ArrayList<Point> p, double oldMin){
        double newMin = oldMin;
        int n = p.size();
        if(n<=1) return oldMin;
        for (int i = 0; i < n; ++i) {
            for (int j = i+1 ; j < n && (p.get(j).y - p.get(i).y) < newMin; ++j) {
                double ans = distance(p.get(j), p.get(i));
                if(ans < newMin){
                    newMin = ans;
                }
            }
        }
        return newMin;
    }
}
