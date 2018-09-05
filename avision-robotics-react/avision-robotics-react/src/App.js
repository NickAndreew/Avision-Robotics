import React, { Component } from 'react';
import './App.css';
import { Switch, Route, Link } from 'react-router-dom';
import FilloutForm from './FilloutForm.js';

class App extends Component {
	render() {
		return (
			<div className="App">
				<div _ngcontent-c2="" className="home-header__top-panel">
					<div _ngcontent-c2="" className="home-header__inner">
						<div _ngcontent-c2="" className="home-header__logo">
							<Link to="/"><img _ngcontent-c2="" alt="Avision Robotics" height="61" 
								src="https://www.avisionrobotics.com/assets/img/logo-home.png" width="203"></img>
							</Link>
						</div>

					</div>
				</div>
				<Switch>
					<Route path="/airplane-input" component={ FilloutForm }></Route>
				</Switch>
			</div>
		);
	}
}

export default App;
