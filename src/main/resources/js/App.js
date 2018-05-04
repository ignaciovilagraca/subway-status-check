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
                    <div className="navbar-brand app-name">Subway Status Checker</div>
                </div>
                <div className="row padded">
                    <LineContainer/>
                </div>
            </div>
        );
    }
}