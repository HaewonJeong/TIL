import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    static void main() {
        TicketService ticketService = new TicketService();
        ticketService.findAll();
        System.out.println("[130 Action ]\n"+(ticketService.findLongActionTitles()));
        System.out.println("[영화 예매 티켓 가격 낮은 순]\n"+
                                        ticketService.findReservedTicketsSorted().stream()
                                                .map(tickect -> tickect.getTitle() + "/" + tickect.getPrice())
                                                .collect(Collectors.joining("\n")));
        System.out.println("[장르 목록]\n"+
                ticketService. findGenres());
        System.out.println("[ageLimit이 19 이상인 영화 개수]\n"+
                ticketService. countAdultMovies());
        Scanner sc = new Scanner(System.in);
        System.out.print("일치 여부 판단 제목 입력: ");
        String keyword = sc.nextLine();
        System.out.println( ticketService.hasMovie(keyword) ) ;
        System.out.println("[예매 완료된 티켓 총 결제 금액]");
        System.out.println(ticketService.getTotalReservedPrice());
        System.out.println("[장르별 영화]");
        ticketService.groupByGenre().forEach( (genre, tickectList) -> {
            String movieTitles = tickectList.stream()
                    .map(MovieTicket::getTitle)
                    .collect(Collectors.joining(", "));
            System.out.println(genre+": "+movieTitles);
        } );

    }
}
