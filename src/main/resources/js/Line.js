import React from "react";

export default class Line extends React.Component {
    toMMSS() {
        var minutes = Math.floor(this.props.line.lineFrequency / 60);
        var seconds = this.props.line.lineFrequency - minutes * 60;
        return (minutes > 9 ? minutes : "0" + minutes) + ":" + (seconds > 9 ? seconds : "0" + seconds);
    }

    render() {
        return (
            <div className="col-md-2">
                <div className="card bg-warning mb-3">
                    <div className="card-block">
                        <div className="card-header centered">{this.props.line.lineName}</div>
                        <div className="card-body">
                            <div className="card-title centered">Estado: {this.props.line.lineStatus}</div>
                            <div
                                className="card-text centered">Frecuencia: {this.toMMSS()}</div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
