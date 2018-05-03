import React from "react";

export default class Line extends React.Component {
    render() {
        return (
            <div className="card bg-light mb-3">
                <div className="card-block">
                    <div className="card-header">{this.props.line.lineName}</div>
                    <p className="card-text">{this.props.line.lineStatus}</p>
                </div>
            </div>
        );
    }
}
