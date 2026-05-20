import java.util.*;
import java.util.stream.Collectors;

public class TicketService {

        ArrayList<MovieTicket> tickets = new ArrayList<>();
        public TicketService() {
            tickets = new ArrayList<>();
            tickets.add(new MovieTicket("Avatar", "SF", 162, 15000, 12, true));
            tickets.add(new MovieTicket("Avatar: The Way of Water", "SF", 192, 16000, 12, false));
            tickets.add(new MovieTicket("Avengers: Endgame", "Action", 181, 16000, 12, true));
            tickets.add(new MovieTicket("Avengers: Infinity War", "Action", 149, 15000, 12, false));
            tickets.add(new MovieTicket("Top Gun: Maverick", "Action", 130, 14000, 12, true));
            tickets.add(new MovieTicket("Deadpool & Wolverine", "Action", 128, 17000, 19, true));
            tickets.add(new MovieTicket("Inside Out 2", "Animation", 96, 12000, 0, true));
            tickets.add(new MovieTicket("Frozen II", "Animation", 103, 11000, 0, false));
        };

        public void Service(){
        }
        public void findAll(){
            tickets.forEach(System.out::println);
        }
        /*Action 장르 중 runningTime이 130분 이상인 영화제목 List 반환*/
        public String findLongActionTitles(){
            String result = "";
//            for(int i=0; i<tickets.size();i++){
//                if( ticket -> tickets.get(i).getRunningTime() > 130){
//                        result += tickets.get(i).getTitle();
//                    }
//            }
            result =  tickets.stream()
                    .filter( ticket -> ticket.getRunningTime() > 130  )
                    .filter(ticket -> ticket.getGenre().equals("Action"))
                    .map(MovieTicket::getTitle)
                    .collect(Collectors.joining(" \n"));
            return result;
        }
        //예매 완료된 티켓을 price 오름차순으로 정렬한 List 반환
        public List<MovieTicket> findReservedTicketsSorted(){

            List<MovieTicket> ticketList = new ArrayList<MovieTicket>();
            ticketList= tickets.stream()
                    .filter(ticket -> ticket.reserved == true)
                    .sorted(Comparator.comparingInt(MovieTicket::getPrice))
                    .collect(Collectors.toList());
            return ticketList;
        }
        //전체 영화의 장르명만 뽑고 distinct()로 중복 제거한 List 반환
        public List<String> findGenres(){

            List<String> ticketList = new ArrayList<String>();
            ticketList = tickets.stream()
                    .map(MovieTicket::getGenre)
                    .distinct()
                    .collect(Collectors.toList());
            return ticketList;

        }
        //ageLimit이 19 이상인 영화 개수를 long으로 반환
        public long countAdultMovies(){
            long result = 0;
            result = tickets.stream()
                    .filter(tickect -> tickect.getAgeLimit() >= 19)
                    .count();
            return result;
        }
        //입력한 제목과 같은 영화가 하나라도 있는지 boolean으로 반환
        public boolean hasMovie(String title){
           return tickets.stream().anyMatch(
                    tickect -> tickect.getTitle().equals(title));
        }
        //예매 완료된 티켓의 총 결제 금액을 int로 반환
        public int getTotalReservedPrice(){
            return tickets.stream()
                    .filter(tickect -> tickect.reserved)
                    //일반 스트림을 숫자 전용 IntStream으로 변환하고 가격(Price) 추출
                    .mapToInt(MovieTicket::getPrice)
                    .sum();
        }
        //장르명을 key로, 영화 예매 목록을 value로 갖는 Map<String, List<MovieTickect> 을 반환
        public Map<String, List<MovieTicket>> groupByGenre(){
            Map<String, List<MovieTicket>> groupgenre;
            groupgenre =  tickets.stream()
                    .collect(Collectors.groupingBy ( ticket -> ticket.getGenre() ));
            return groupgenre;
        }

}
