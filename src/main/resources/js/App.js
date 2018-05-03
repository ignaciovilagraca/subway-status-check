import React from "react";
import LineContainer from "./LineContainer";

export default class App extends React.Component {
    constructor() {
        super();
    }

    render() {
        return (
            <div>
                <div className="navbar bg-dark">
                    <a className="navbar-brand" href="/">Subway Status Checker</a>
                </div>
                <div className="row padded">
                    <div className="col-md-2">

                    </div>
                    <div className="col-md-8">
                        <LineContainer/>
                    </div>
                    <div className="col-md-2">

                    </div>
                </div>
            </div>
        );
    }
}