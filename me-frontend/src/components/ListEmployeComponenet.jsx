import React,{useEffect, useState} from 'react';
import { deleteEmploye, listEmploye } from '../services/EmployeService';
import { useNavigate } from 'react-router-dom';
function ListEmployeComponenet() {

const [employes, setEmployes]=useState([]);
const navigator = useNavigate();

useEffect (()=>{

            getAllEmployes();

    },[]);


    const getAllEmployes =()=>{
        listEmploye().then((response)=>{

            setEmployes(response.data);

        }).catch(error=>{

            console.log(error);
        });
    }

    const updateEmploye =(id)=>{
        navigator(`/edite-employe/${id}`);
    };

   const removeEmploye = (id)=>{
     console.log(id);
     deleteEmploye(id).then((response)=>{
        getAllEmployes();
     }).catch(error=>{
        console.log(error);
     });

   };

    const adNewEmploye = ()=>{
        navigator("/add-employe");
    };
  return (
    <div className='container'>
        <h2 className='text-center'>List of Employes</h2>
        <button className="btn btn-primary mb-2" onClick={adNewEmploye}>Add employe</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employe Id</th>
                    <th>Employe First Name</th>
                    <th>Employe Last Name</th>
                    <th>Employe Email Id</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>
                {
                    employes.map(employe=>
                    <tr key={employe.id}>
                        <td>{employe.id}</td>
                        <td>{employe.firstName}</td>
                        <td>{employe.lastName}</td>
                        <td>{employe.email}</td>
                        <td>
                             <button className="btn btn-info" onClick={()=>updateEmploye(employe.id)}>Update</button>
                             <button className="btn btn-danger" onClick={()=>removeEmploye(employe.id)}>delete</button>
                         </td>
                    </tr>
                    )
                }
                <tr>

                </tr>
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeComponenet
