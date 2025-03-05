const canvasWidth = 800;
const canvasHeight = 600;

const circleData = {
    xPosition: canvasHeight / 2,
    yPosition: canvasWidth / 2,
    horizontalDirection: 1,
    verticalDirection: -1,
    velocity: 5,
    diameter: 25
};

const leftRacketData = {
    width: 15,
    height: 100,
    xPosition: 0,
    yPosition: canvasHeight / 2,
    velocity: 5
};

const rightRacketData = {
    width: 15,
    height: 100,
    xPosition: canvasWidth - 15,
    yPosition: canvasHeight / 2,
    velocity: 5
}

function setup() {
    createCanvas(canvasWidth, canvasHeight);
}

function draw() {
    background(60);

    circle(circleData.xPosition, circleData.yPosition, 25);
    rect(leftRacketData.xPosition, leftRacketData.yPosition, leftRacketData.width, leftRacketData.height);
    rect(rightRacketData.xPosition, rightRacketData.yPosition, rightRacketData.width, rightRacketData.height);

    verifyHorizontalWallColision();
    verifyVerticalWallColision();
}

function verifyHorizontalWallColision() {
    const result = verifyWallColision(
        circleData.xPosition,
        circleData.horizontalDirection,
        circleData.velocity,
        canvasWidth
    );
    circleData.horizontalDirection = result.direction;
    circleData.xPosition += result.newPosition;
}

function verifyVerticalWallColision() {
    const result = verifyWallColision(
        circleData.yPosition,
        circleData.verticalDirection,
        circleData.velocity,
        canvasHeight
    );
    circleData.verticalDirection = result.direction;
    circleData.yPosition += result.newPosition;
}

function verifyWallColision(position, direction, velocity, dimensionValue) {
    if (isColidedWithRightWall(position, dimensionValue)) {
        direction = -1;
    } else if (isColidedWithLeftWall(position)) {
        direction = 1;
    }
    return { direction, newPosition: direction * velocity };
}

function isColidedWithRightWall(position, dimensionValue) {
    return position >= (dimensionValue - circleData.diameter / 2);
}

function isColidedWithLeftWall(position) {
    return position <= 0;
}

function verifyRacketColision() {
    if (circleData.xPosition >= rightRacketData.xPosition &&
        (circleData.yPosition <= rightRacketData.yPosition + rightRacketData.height / 2 ||
            circleData.yPosition >= rightRacketData.yPosition - rightRacketData.height / 2)
    ) {
        circleData.horizontalDirection *= -1;
        circleData.verticalDirection *= -1;
    }
}