import React, { Component } from 'react';
import './App.css';
// import { Link } from 'react-router-dom';

class FilloutForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            pointsInputs: []
        };

        this.handleAddPoint = this.handleAddPoint.bind(this);
    }

    componentDidMount() {

    }

    handleAddPoint() {
        var points = this.state.points;

        points.push(points.length + 1);
        console.log(points.toString());
        this.setState({ pointsInputs: points });

    }

    render() {

        var inputLocationPoints = this.state.pointsInputs;

        return (
            <div className="FilloutForm">

                <div className="container">
                    <div className="row">
                        <h4 className="titleCl">Set Aircraft Specs</h4>
                        <div className="col-sm-3">
                            <h5 className="text">Speed</h5>
                            <input placeholder="m/s, e.g. (12.5)" className="form-control" />
                        </div>
                        <div className="col-sm-3">
                            <h5 className="text">Acceleration</h5>
                            <input placeholder="m/s², e.g. (3.2)" className="form-control" />
                        </div>
                        <div className="col-sm-3">
                            <h5 className="text">Velocity of height change</h5>
                            <input placeholder="m/s, e.g. (2.9)" className="form-control" />
                        </div>
                        <div className="col-sm-3">
                            <h5 className="text">Velocity of direction change</h5>
                            <input placeholder="m/s, e.g. (1.88)" className="form-control" />
                        </div>
                    </div>
                    <div className="row">
                        <h4 className="titleCl">Set Flight Info</h4>
                        <div className="col-sm-3">
                            <h5 className="text">Flight Number</h5>
                            <input placeholder="1234" className="form-control" />
                        </div>
                        <div className="col-sm-3">

                        </div>
                        <div className="col-sm-3">

                        </div>
                        <div className="col-sm-3">

                        </div>
                    </div>
                    <div className="row">
                        <div className="row" id="pointsList">
                            <h5 className="text">Route Points for the flight</h5>
                            <button onClick={this.handleAddPoint}>Add Point</button>
                            <button>Remove Point</button>
                            <h5 className="text"></h5>

                            <div className="col-sm-3">
                                <h5 className="text">Latitude</h5>
                                <input placeholder="lat" className="form-control" />
                            </div>
                            <div className="col-sm-3">
                                <h5 className="text">Longitude</h5>
                                <input placeholder="lng" className="form-control" />
                            </div>
                            <div className="col-sm-3">
                                <h5 className="text">Height</h5>
                                <input placeholder="lng" className="form-control" />
                            </div>
                            <div className="col-sm-3">
                                <h5 className="text">Speed</h5>
                                <input placeholder="lng" className="form-control" />
                            </div>
                            {
                                inputLocationPoints.map((point) => {
                                    <div key={point} className="row">
                                        <div className="col-sm-3">
                                            <h5 className="text"></h5>
                                            <input placeholder="lat" className="form-control" />
                                        </div>
                                        <div className="col-sm-3">
                                            <h5 className="text"></h5>
                                            <input placeholder="lng" className="form-control" />
                                        </div>
                                        <div className="col-sm-3">
                                            <h5 className="text"></h5>
                                            <input placeholder="lng" className="form-control" />
                                        </div>
                                        <div className="col-sm-3">
                                            <h5 className="text"></h5>
                                            <input placeholder="lng" className="form-control" />
                                        </div>
                                    </div>
                                })
                            }
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default FilloutForm;
