import React from "react";
import LineContainer from "./LineContainer";

export default class App extends React.Component {
    render() {
        return (
            <div>
                <div className="navbar bg-dark">
                    <div className="navbar-brand app-name">Estado de la Red - Metrovías</div>
                </div>
                <div className="row padded">
                    <LineContainer/>
                </div>
            </div>
        );
    }
}