import axios from 'axios'
export const api = axios.create({
    baseURL :"http://localhost:8080"
})

//add room to database
export async function addRoom(photo , roomType , roomPrice) {
    const formData = new FormData()
    formData.append("photo" , photo)
    formData.append("roomType" , roomType)
    formData.append("roomPrice" , roomPrice)

    const response = await api.post("/rooms/add/new-room". formData)

    if(response.status === 201){
        return true
    }else{
        return false
    }
    
}

//get all room type from database
export async function getRoomTypes() {
    try {
        const response = await api.get("/rooms/roomtypes")
        return response.data
    } catch (error) {
        throw new Error ("Error In Fetching Room Types" , error)
        
    }
    
}