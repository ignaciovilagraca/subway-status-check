import React from "react";
import axios from "axios/index";
import Line from "./Line";

export default class LineContainer extends React.Component {
    constructor() {
        super();
        this.state = {
            lines: []
        };
    }

    componentDidMount() {
        this.fetchLines();
    }

    fetchLines() {
        axios.get('/Status')
            .then((response) => {
                this.setState({
                    lines: response.data
                });
            });
    }

    render() {
        return (this.state.lines.map(line => <Line line={line}/>));
    }
}
