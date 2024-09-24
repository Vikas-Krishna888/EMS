import React from 'react';
import { NavLink } from 'react-router-dom';

export const HeaderComponent = () => {
  return (
    <div>
      <header>
        <nav className='navbar navbar-expand-lg navbar-dark bg-primary'>
          <NavLink className='navbar-brand' href='/employees'>
            Employee Management Systems
          </NavLink>
          <div className='collapse navbar-collapse' id='navbarNav'>
            <ul className='navbar-nav'>
              <li className='nav-item'>
                <NavLink className='nav-link' to='/employees'>
                  Employees
                </NavLink>
              </li>

              <li className='nav-item'>
                <NavLink className='nav-link' to='/departments'>
                  Departments
                </NavLink>
              </li>
            </ul>
          </div>
        </nav>
      </header>
    </div>
  );
};
