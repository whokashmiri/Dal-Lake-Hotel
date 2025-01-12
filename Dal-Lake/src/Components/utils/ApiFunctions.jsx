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
//get all room type from database
export async function getRoomTypes() {
    try {
      const response = await api.get("/rooms/room/types");
      if (!response.ok) {
         // throw an error when request fails (ex: 404 Not Found, 500 Internal Server Error)
         throw new Error(`Error In Fetching Room Types. Status: ${response.status}`, {cause: new Error(response.statusText)});
      }
      return response.data;
    } catch (error) {
      console.error("Error fetching room types:", error);
      // Throw the error, so it can be handled outside the function.
      // you could send a more specific message based on the cause of the error, in the catch
      throw new Error("Error In Fetching Room Types", {cause: error});
    }
  }