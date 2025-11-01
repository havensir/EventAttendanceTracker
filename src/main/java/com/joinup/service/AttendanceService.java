public void registerAttendance(String attendeeName) {
    validateAttendee(attendeeName);
    persistAttendance(attendeeName);
    notifyUI(attendeeName);
}

private void validateAttendee(String attendeeName) {
    if (attendeeName == null || attendeeName.isEmpty()) {
        throw new IllegalArgumentException("Attendee name cannot be null or empty");
    }
}

private void persistAttendance(String attendeeName) {
    database.save(attendeeName);
}

private void notifyUI(String attendeeName) {
    ui.showToast(attendeeName + " registered successfully");
}
