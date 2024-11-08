import { useQuery } from "@tanstack/react-query";
import axios from "axios"
import { useState } from "react"


const fetchFunc = async () => {
    const response = await axios.get("http://localhost:8080/api");
    return response.data;

}


const GetComponent = () => {

    const {data, isLoading, isError, error} = useQuery({
        queryKey: ['myData'],
        queryFn: fetchFunc,
    });


    if(isLoading) return <div>Is Loading...</div>
    if(isError) return <div>Error {error.message}</div>


    return (

        <>
        <button onClick={fetchFunc} >
            Get
        </button>
        <p>{data}</p>
        </>

    )
}

export default GetComponent