function dateStringOffSetCorrection(dateString) {
    const date = new Date(dateString);
    const timezoneOffset = date.getTimezoneOffset() * 60 * 1000;
    date.setTime(date.getTime() + timezoneOffset);
    return date;
}

export default dateStringOffSetCorrection;