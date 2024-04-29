import random

from flask import Flask, request, jsonify
from time import time


app = Flask(__name__)


sensors = {
    'sensor1': {
        'name': 'sensor1',
        'data': 40,
        'timestamp': int(time() * 1000)
    },
    'sensor2': {
        'name': 'sensor2',
        'data': 60,
        'timestamp': int(time() * 1000)
    },
    'sensor3': {
        'name': 'sensor3',
        'data': 30,
        'timestamp': int(time() * 1000)
    },

}


@app.route('/api/v1/sensors', methods=['GET'])
def get_sensor_data():
    global sensors

    name = request.args.get('name')
    r = random.randint(-2, 2)
    d = sensors[name]['data'] + r

    sensors[name]['data'] = d
    sensors[name]['timestamp'] = int(time() * 1000)

    return sensors[name]


@app.route('/api/v1/sensors', methods=['POST'])
def set_points_sensor():
    global sensors

    data = request.json
    sensor = data.get('sensor')
    setpoint = data.get('setpoint')

    sensors[sensor]['data'] = setpoint

    return jsonify(success=True)


@app.route('/api/v1/sensors', methods=['PUT'])
def update_sensor():
    global sensors

    data = request.json
    sensor = data.get('sensor')
    setpoint = data.get('setpoint')

    if sensor in sensors:
        sensors[sensor]['data'] = setpoint
    else:
        sensors[sensor] = {
            'name': sensor,
            'data': setpoint,
            'timestamp': int(time() * 1000)
        }

    return jsonify(success=True)


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)

