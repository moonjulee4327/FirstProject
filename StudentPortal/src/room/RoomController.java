package room;

import java.util.List;

public class RoomController {
	//필드
	private static RoomController studentController = new RoomController();
	private RoomService roomService = RoomService.getInstance();
	
	//생성자
	private RoomController() {}
	
	//메소드
	public static RoomController getInstance() {
		return studentController;
	}
	
	public List<RoomVO> selectRoom() {
		return roomService.selectRoom();
	}
	
	public RoomVO selectOneRoom(RoomVO vo) {
		return roomService.selectOneRoom(vo);
	}
	
	public int insertRoom(RoomVO vo) {
		return roomService.insertRoom(vo);
	}
	
	public int updateRoom(RoomVO vo) {
		return roomService.updateRoom(vo);
	}
	
	public int deleteRoom(RoomVO vo) {
		return roomService.deleteRoom(vo);
	}
}
