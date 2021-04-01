import java.util.HashMap;
import java.util.Map;

/**
 * Member 객체를 집합의 형태로 관리하는 클래스 
 * 주로 database와 인터페이스
 */
public class MemberDao {
	// member id
	private static long nextId = 0;
	// member를 저장하고 관리하는 collection
	// map  (key : value)
	// 대표적인 다형성 사례
	private Map<String, Member> map 
	= new HashMap<String, Member>(); 
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public Member selectByEmail(String email) {
		Member member =  map.get(email);
		return member;
	}
	

}
