package com.hoteldal.Dal.Lake.Hotel.Controller;

import com.hoteldal.Dal.Lake.Hotel.Model.Room;
import com.hoteldal.Dal.Lake.Hotel.Response.RoomResponse;
import com.hoteldal.Dal.Lake.Hotel.Service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final IRoomService roomService;

    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping(value = "/add/new-room", produces = "application/json")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice")BigDecimal roomPrice
            ) throws SQLException, IOException {
        Room savedRoom  = roomService.addNewRoom(photo , roomType , roomPrice);

        RoomResponse  response = new RoomResponse(savedRoom.getId(),
                savedRoom.getRoomType() , savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }


}
