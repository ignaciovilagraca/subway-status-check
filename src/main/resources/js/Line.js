import React from "react";
import moment from "moment";

export default class Line extends React.Component {
    render() {
        return (
            <div className="col-md-2">
                <div className="card bg-warning mb-3">
                    <div className="card-block">
                        <div className="card-header centered">{this.props.line.lineName}</div>
                        <div className="card-body">
                            <div className="card-title centered">Estado: {this.props.line.lineStatus}</div>
                            <div
                                className="card-text centered">Frecuencia: {moment().seconds(this.props.line.lineFrequency).format('mm:ss')}</div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
