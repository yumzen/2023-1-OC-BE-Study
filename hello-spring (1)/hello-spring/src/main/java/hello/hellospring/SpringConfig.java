package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.Memberservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
   /* private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    */
    //SpringDataJpaMemberRepository 인터페이스를 만들어놓았기 때문에
   // 스프링데이터가 인터페이스에 대한 구현체를 자동으로 만들고 스트링 빈에 등록해두었다.
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public Memberservice memberService() {
        return new Memberservice(memberRepository);
    }
    /* @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
    */
}
