/* eslint-disable no-unused-vars */
import { useState } from 'react'
import { addRoom } from '../utils/ApiFunctions'
import RoomTypeSelector from '../common/RoomTypeSelector'

export const AddRoom = () => {
    const [newRoom , setNewRoom] = useState({

        photo:null,
        roomType:"",
        roomPrice:""
    })
    const [imagePreview , setImagePreview] = useState("")
    const [ successMessage , setSuccessMessage] = useState("")
    const [ errormessage , setErrorMessage] = useState("")

    const  handleRoomInputChange = (e)=>{
        const name  = e.target.name
        let value = e.target.value
        if(name === "roomType"){
        if(!isNaN(value)){

            value=parseInt(value)
        }
        else{
            value=""
        }

    }
    setNewRoom({...newRoom, [name] : value})
    }

    const handleImageChange =(e)=>{
        const selectedImage = e.target.files[0]
        setNewRoom({...newRoom , photo : selectedImage})
        setImagePreview(URL.createObjectURL(selectedImage))

    }

    const handleSubmit =async (e)=>{
        e.preventDefault()

        try {
            const success =  await addRoom(newRoom.photo , newRoom.roomPrice . newRoom.roomType)
            if(success !== undefined){
                setSuccessMessage("Room Added To Database")
                setNewRoom({photo:null , roomType :"", roomPrice :""})
                setImagePreview("")
                setErrorMessage("")
            }
            else{
                setErrorMessage("Error In Adding Room")
            }
        } catch (error) {
            setErrorMessage(error.message)
        }
    }
  return (
    <>
    <section className='container , mt-5 mb-5'>
        <div className='row justify-content-center'>
            <div className='col-md-8 col-lg-6'>
                <h2 className='mt-5 mb-2'>Add A New Room</h2>
                <form onSubmit={handleSubmit}>
                    <div className='mb-3' >
                        <label className='form-label' htmlFor="roomType">Room Type</label>
                        <div>
                            <RoomTypeSelector
                            handleRoomInputChange={handleRoomInputChange}
                            newRoom={newRoom}
                            />
                        </div>
                    </div>
                    <div className='mb-3' >
                        <label className='form-label' htmlFor="roomPrice">Room Price</label>
                        <input className='form-control' required id='roomPrice' name="roomPrice" value={newRoom.roomPrice} type='number' onChange={handleRoomInputChange}
                        />
                            
                   
                    </div>
                    <div className='mb-3' >
                        <label className='form-label' htmlFor="photo">Room Photo</label>
                        <input id='photo'  name='photo' type='file' className='form-control' onChange={handleImageChange}/>

                            
                        {imagePreview && (
                            <img src={imagePreview} alt='Room Photo' style={{maxWidth:"400px" , maxHeight:"400px"}}
                            className='mb-3'
                            />
                        )}
                    </div>
                    <div className='d-grid d-md-flex mt-2'>
                        <button className='btn btn-outline-primary ml-5'>Save Room</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
    </>
  )
}
