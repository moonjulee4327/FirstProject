package room;

import java.util.List;

public class RoomService {
	//필드
	private static RoomService studentService = new RoomService();
	private RoomDAO roomDAO = RoomDAO.getInstance();
	
	//생성자
	private RoomService() {}
	
	//메소드
	public static RoomService getInstance() {
		return studentService;
	}
	
	public List<RoomVO> selectRoom() {
		
		try {
			return roomDAO.selectRoom();
		} catch (Exception e) {
			return null;
		}
	}
	public RoomVO selectOneRoom(RoomVO vo) {
		
		try {
			return roomDAO.selectOneRoom(vo);
		} catch (Exception e) {
			return null;
		}
	}
	public int insertRoom(RoomVO vo) {
		try {
			return roomDAO.insertRoom(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int updateRoom(RoomVO vo) {
		try {
			return roomDAO.updateRoom(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	public int deleteRoom(RoomVO vo) {
		try {
			return roomDAO.deleteRoom(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	
}
