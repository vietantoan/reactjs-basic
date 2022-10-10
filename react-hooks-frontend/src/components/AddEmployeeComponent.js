import React, { useState } from 'react'
// import { Link, useHistory } from 'react-router-dom'
import { Link, useNavigate } from 'react-router-dom'
import EmployeeService from '../services/EmployeeService'

const AddEmployeeComponent = () => {
    
    const [firstName, setfirstName] = useState('')
    const [lastName, setlastName] = useState('')
    const [emailId, setemailId] = useState('')
    // const history = useHistory();
    const navigate = useNavigate();
    const saveEmployee = (e) => {
        e.preventDefault();
        const employee = {firstName, lastName, emailId} 

      EmployeeService.createEmployee(employee).then((response)=> {

        console.log(response.data)
        navigate("/employees")
        // history.push('/employees')

      }).catch(error => {
          console.log(error)
      })
    }
    
    return (
    <div>
        <br>
        </br>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3">
                    {/* {
                           title()
                       } */}

                         </div>
                        <h2 className="text-center">Add Employee</h2>
                        <div className="card-body">
                            <form>
                                    <div className="form-group mb-2">
                                        <label className="form-label">FirstName</label>
                                        <input 
                                        type="text" 
                                        placeholder="enter first name" 
                                        name = "firstName" 
                                        className="form-control" 
                                        value={firstName} 
                                        onChange={(e)=>setfirstName(e.target.value)}>

                                        </input>

                                    </div>
                                    <div className="form-group mb-2">
                                        <label className="form-label">lastName</label>
                                        <input 
                                        type="text" 
                                        placeholder="enter last name" 
                                        name = "lastName" 
                                        className="form-control" 
                                        value={lastName} 
                                        onChange={(e)=>setlastName(e.target.value)}>

                                        </input>
                                            
                                    </div>
                                    <div className="form-group mb-2">
                                        <label className="form-label">Email</label>
                                        <input 
                                        type="email" 
                                        placeholder="enter email" 
                                        name = "emailId" 
                                        className="form-control" 
                                        value={emailId} 
                                        onChange={(e)=>setemailId(e.target.value)}>

                                        </input>
                                            
                                    </div>
                                    <button className="btn btn-success" onClick = {(e)=> saveEmployee(e)}> Submit</button>
                                    <Link  to ="/employees" className="btn btn-danger"> Cancel</Link>
                            </form>
                        </div>
                </div>
            </div>

    </div>
  )
}

export default AddEmployeeComponent