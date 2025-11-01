try {
    preparedStatement.executeUpdate();
} catch (SQLException e) {
    logger.error("Failed to execute update for attendee", e);
    throw new RuntimeException("Database error occurred", e);
}
