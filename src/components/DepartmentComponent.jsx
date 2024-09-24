import React, { useEffect, useState } from 'react';
import {
  createDepartment,
  getDepartmentById,
  updateDepartment,
} from '../services/DepartmentService';
import { useNavigate, useParams } from 'react-router-dom';

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState('');
  const [departmentDescription, setDepartmentDescription] = useState('');
  const navigator = useNavigate();
  const { id } = useParams();

  function saveDepartment(e) {
    e.preventDefault();
    const department = {
      departmentName: departmentName,
      departmentDescription: departmentDescription,
    };
    if (id) {
      updateDepartment(id, department)
        .then((response) => {
          console.log(response.data);
          navigator('/departments');
        })
        .catch((error) => {
          console.error(error);
        });
    } else {
      createDepartment(department)
        .then((response) => {
          console.log(response.data);
          navigator('/departments');
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }

  useEffect(() => {
    if (id) {
      getDepartmentById(id)
        .then((response) => {
          setDepartmentName(response.data.departmentName);
          setDepartmentDescription(response.data.departmentDescription);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function pageTitle() {
    if (id) {
      return <h3 className='text-center'>Update Department</h3>;
    } else {
      return <h3 className='text-center'>Add Department</h3>;
    }
  }

  return (
    <div className='container'>
      <br />
      <br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
          <h3 className='text-center'> {pageTitle()}</h3>
          <div className='card-body'>
            <form>
              <div className='form-group mb-2'>
                <label className='form-label'>Department Name:</label>

                <input
                  placeholder='Department Name'
                  type='text'
                  name='departmentName'
                  className='form-control'
                  value={departmentName}
                  onChange={(e) => setDepartmentName(e.target.value)}
                />
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Department Description:</label>
                <input
                  placeholder='Department Description'
                  type='text'
                  name='departmentDescription'
                  className='form-control'
                  value={departmentDescription}
                  onChange={(e) => setDepartmentDescription(e.target.value)}
                />
              </div>
              <button
                className='btn btn-success mb-2'
                onClick={(e) => saveDepartment(e)}
              >
                Save
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DepartmentComponent;
