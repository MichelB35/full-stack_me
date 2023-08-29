import React ,{useEffect, useState}from 'react';
import { createEmploye, getEmploye, updateEmploye } from '../services/EmployeService';
import { useNavigate, useParams } from 'react-router-dom';

function EmployeCompnts() {
    const[firstName,setFirstName] = useState('');
    const [lastName,setLastName] = useState('');
    const [email, setEmail] = useState('');
    const navigator =  useNavigate();
    const  {id} = useParams();

    const [errors,setErrors] = useState({
        firstName:'',
        lastName:'',
        email:''    });

        useEffect(()=>{
                if(id){
                    getEmploye(id).then((response)=>{
                    setFirstName(response.data.firstName);
                    setLastName(response.data.lastName);
                    setEmail(response.data.email);
                    }).catch(error=>{
                        console.log(error)
                    });
                }
        },
        []);

        const pageTitl =()=>{
            if(id){
                return <h2 className="text-center"> Update Employe </h2>
            }else{
                return <h2 className="text-center"> Update Employe </h2>
            }
           }

    const handleFirstName = (e) =>{
        setFirstName(e.target.value);
    };

    const handleLaststName =(e)=>{
        setLastName(e.target.value);
    };

    const handleEmail = (e) =>{
        setEmail(e.target.value);
    };

    const saveEmploye = (e)=>{
        e.preventDefault();

       
           
        const employe ={firstName,lastName,email}
        if(validateForm()){
            
         } if(id){
                updateEmploye(id, employe).then((response)=>{
                    console.log(response.data);
                    navigator('/employes');
                }).catch(
                    error=>{
                        console.log(error)
                    }
                )
               }else{
                console.log(employe);
                createEmploye(employe).then(response=>{
                    console.log(response.data);
                    navigator('/employes');
                
                });
          
        
        }
       
    };

    const validateForm =()=>{
        let valid = true;
        const errorCopy ={... errors};
        if(firstName.trim()){
            errorCopy.firstName ='';
        }else{
            errorCopy.firstName ='First name is required';
            valid = false;
        }
        if(lastName.trim()){
            errorCopy.lastName = '';

        }else{
            errorCopy.lastName = "Last Name is requiered";
            valid = false;
        }

        if(email.trim()){
            errorCopy.email ='';

        }else{
            errorCopy.email ="Email is required";   
        }
        setErrors(errorCopy);
    };

  
       


    

    return (
    <div className="container">
            <div className="row">
                    <div className="card">
                    {
                        pageTitl()
                    };
                    <div className="card-body">
                        <form action="">
                            <div className="form-group mb-2">
                                <label className="form-label">First Name :</label>
                                <input type="text" placeholder='Enter Employe First Name' name='firstName' value={firstName}  className={`form-control ${errors.firstName? 'is-invalid':''}`} onChange={handleFirstName}/>
                                {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div> }
                                <label className=""></label>
                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Last Name :</label>
                                <input type="text" placeholder='Enter Employe Last Name' name='lastName' value={lastName}  className={`form-control ${errors.lastName? 'is-invalid':''}`} onChange={handleLaststName}/>
                                {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div> }
                                <label className=""></label>
                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Email :</label>
                                <input type="text" placeholder='Enter Email' name='Email' value={email}  className={`form-control ${errors.email? 'is-invalid':''}`} onChange={handleEmail}/>
                                <label className=""></label>
                                {errors.email && <div className="invalid-feedback">{errors.email}</div> }
                            </div>
                            <button className="btn btn-success" onClick={saveEmploye}>Submit</button>
                        </form>

                    </div>

                    </div>
            </div>
      </div>
  )
}

export default EmployeCompnts
