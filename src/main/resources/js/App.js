import React from "react";

export default class App extends React.Component {
    constructor() {
        super();
    }

    render() {
        return (
            <div>
                <div className="navbar bg-dark">
                    <a className="navbar-brand" href="/">Subway Status Check</a>
                </div>
                <div className="row padded">
                </div>
            </div>
        );
    }
}