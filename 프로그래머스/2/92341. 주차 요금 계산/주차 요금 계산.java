import java.util.*;
import java.io.*;

class Solution {
    class Time {
        int in_time, out_time;
        
        public Time(int in_time, int out_time) {
            this.in_time = in_time;
            this.out_time = out_time;
        }
    }
    
    class Money implements Comparable<Money> {
        String num;
        int fee;
        
        public Money(String num, int fee) {
            this.num = num;
            this.fee = fee;
        }
        
        @Override
        public int compareTo(Money m) {
            return this.num.compareTo(m.num);
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st = null;
        
        HashMap<String, Time> hm = new HashMap<>();
        PriorityQueue<Money> pq = new PriorityQueue<>();
        HashMap<String, Integer> mm = new HashMap<>();
        
        for(int i=0;i<records.length;i++) {
            st = new StringTokenizer(records[i], " ");
            
            String time = st.nextToken();
            String num = st.nextToken();
            String status = st.nextToken();
            
            st = new StringTokenizer(time, ":");
            int timeTotal = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            
            if(status.equals("IN")) {
                hm.put(num, new Time(timeTotal, 23*60 + 59));
            }
            else {
                hm.put(num, new Time(hm.get(num).in_time, timeTotal));
                int t = timeTotal - hm.get(num).in_time;
                mm.put(num, mm.containsKey(num)? mm.get(num) + t: t);
                hm.remove(num);
            }
            
        }
        for(Map.Entry<String, Time> e : hm.entrySet()) {
            String num = e.getKey();
            Time time = e.getValue();
            
            int t = time.out_time - time.in_time;
            mm.put(num, mm.containsKey(num)? mm.get(num) + t: t);
        }
        
        for(Map.Entry<String, Integer> e : mm.entrySet()) {
            String num = e.getKey();
            int time = e.getValue();
            
            int totalTime = time - fees[0];
            System.out.println(time + " : " +totalTime);
            int money = totalTime < 0? fees[1]: (fees[1] + (int)Math.ceil(totalTime*1.0 / fees[2])*fees[3]);
            pq.add(new Money(num, money));
        }
        
        int[] answer = new int[pq.size()];
        int a = 0;
        while(!pq.isEmpty()) {
            Money cur = pq.poll();            
            answer[a++] = cur.fee;
        }
        return answer;
    }
}