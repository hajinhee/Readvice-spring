package kr.readvice.api.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


public class MemberCRUD {
    //controller Class
    public static void main(String[] args) {
        MemberService service = new MemberServiceImpl();
        while (true){
            Scanner s = new Scanner(System.in);
            System.out.println("0.exit 1.save 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existsById 9.clear");
            switch (s.next()){
                case "0": return;
                case "1":
                    Member hong = new Member.Builder("hong")
                            .email("hong.test.com")
                            .name("홍길동")
                            .password("1234")
                            .phone("010-1111-2222")
                            .profileImg("hong.jpg")
                            .build();
                    service.save(hong);
                    Member ha = new Member.Builder("ha")
                            .email("ha.test.com")
                            .name("하진희")
                            .password("1234")
                            .phone("010-1111-2222")
                            .profileImg("ha.jpg")
                            .build();
                    service.save(ha);
                break;
                case "2":
                    break;
                case "3":
                    Member temp = new Member();
                    temp.setUserid("hong");
                    service.delete(temp);
                    break;
                case "4":
                    System.out.println((service.existsById("hong") ? service.findById("hong") : "찾는 아이디가 없습니다."));
//                    System.out.println((service.findById("hong") != null) ? service.findById("hong") : "찾는 아이디가 없습니다.");
                    break;
                case "5": break;
                case "6":
                    break;
                case "7":
                    System.out.println("총 회원수: "+service.count()+"명");
                    break;
                case "8":
                    System.out.println(service.existsById("hong"));
                    break;
                case "9":
                    service.clear();
                    break;
                default: break;
            }
        }
    }
    //DTO
    @Data @NoArgsConstructor
    static class Member{
        protected String userid, name, password, profileImg, phone, email;
        // 2
        public Member(Builder builder) {
            this.userid = builder.userid;
            this.name = builder.name;
            this.password = builder.password;
            this.profileImg = builder.profileImg;
            this.phone = builder.phone;
            this.email = builder.email;
        }
        // 1
        static class Builder{
            private String userid, name, password, profileImg, phone, email;
            public Builder (String userid){this.userid=userid;}
            public Builder name(String name){this.name=name; return this;}
            public Builder password(String password){this.password=password; return this;}
            public Builder profileImg(String profileImg){this.profileImg=profileImg; return this;}
            public Builder phone(String phone){this.phone=phone; return this;}
            public Builder email(String email){this.email=email; return this;}
            Member build(){ return new Member(this);}
        }
        @Override public String toString(){
            return String.format("[사용자 스펙] userid: %s, name: %s, password: %s, profileImg: %s, phone: %s, email: %s",
                    userid, name, password, profileImg, phone, email);
        }
    }

    //Service interface
    interface MemberService{
        void save(Member member);
        void update(Member member);
        void delete(Member member);
        void clear();
        Member findById(String id); //해당 id 찾기, 파라미터=id
        List<Member> findByName(String name);//null 이나 동명이인이 있으니 List로 감싸준다.
        List<Member> findAll(); //findAll = 전체를 가져오는 것, 파라미터가 없음
        int count(); //count = int, 파라미터가 없음
        boolean existsById(String id); //id 존재유무 확인, 파라미터=id

    }

    //Service implement
    static class MemberServiceImpl implements MemberService{
        private final Map<String, Member> map; // Map = 리덕스의 스토어 역할
        MemberServiceImpl(){
            map = new HashMap<>();
        }

        @Override
        public void save(Member member){
            map.put(member.getUserid(), member);
        }
        @Override
        public void update(Member member) {
            map.replace(member.getUserid(), member);
        }
        @Override
        public void delete(Member member) {
            System.out.println("삭제할 아이디: "+ member.getUserid());
            map.remove(member.getUserid());
        }
        @Override
        public void clear() {
            map.clear();
        }
        @Override
        public Member findById(String id) {
            return map.get(id);
        }
        @Override
        public List<Member> findByName(String name) {
            return null;
        }
        @Override
        public List<Member> findAll() {
            return null;
        }
        @Override
        public int count() {
            return map.size();
        }
        @Override
        public boolean existsById(String id) {
            return map.containsKey(id);
        }
    }
}
