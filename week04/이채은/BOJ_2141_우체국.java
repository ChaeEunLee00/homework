import java.io.*;
import java.util.*;

public class Main{

    public static class Town implements Comparable<Town>{
        long location, people;
        public Town(long location, long people){
            this.location = location;
            this.people = people;
        }

        @Override
        public int compareTo(Town o){
            return (int)(this.location - o.location);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Town> towns = new ArrayList<>();
        long totalPeople = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long locatoin = Integer.parseInt(st.nextToken());
            long people = Integer.parseInt(st.nextToken());

            totalPeople += people;
            towns.add(new Town(locatoin,people));
        }

        long mid = (totalPeople + 1)/2;
        Collections.sort(towns);

        long peopleSum = 0;
        for(int i = 0; i < N; i++){
            Town town = towns.get(i);
            peopleSum += town.people;
            if(peopleSum >= mid){
                System.out.println(town.location);
                break;
            }
        }

        br.close();
    }
}