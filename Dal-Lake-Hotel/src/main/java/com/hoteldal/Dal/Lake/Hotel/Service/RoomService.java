package com.hoteldal.Dal.Lake.Hotel.Service;

import com.hoteldal.Dal.Lake.Hotel.Model.Room;
import com.hoteldal.Dal.Lake.Hotel.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService{
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws SQLException, IOException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);

        if(!file.isEmpty()){
            byte [] photoBytes = file.getBytes(); //Expecting a Blob given a byte[]
            Blob photoBlob = new SerialBlob(photoBytes); //Converting byte into Blob
            room.setPhoto(photoBlob);
        }
        return roomRepository.save(room);
    }
}
