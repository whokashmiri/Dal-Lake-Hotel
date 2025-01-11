import {useEffect, useState} from 'react'
import { getRoomTypes } from '../utils/ApiFunctions'

const RoomTypeSelector = () =>{
    const [ roomTypes , setRoomTypes] = useState([])
    const [ showNewRoomTypeInput , setShowNewRoomTypeInput] = (false)
    const [newRoomType , setNewRoomType] = useState("")

    useEffect(()=>{
        getRoomTypes().then((data)=>{
            setRoomTypes(data)
        })
    },[])

  return (
    <div>
        
    </div>
  )
}

export default RoomTypeSelector