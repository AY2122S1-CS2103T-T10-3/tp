package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddAllTagCommand;
import seedu.address.model.tag.Tag;

class AddAllTagCommandParserTest {
    private AddAllTagCommandParser parser = new AddAllTagCommandParser();

    @Test
    public void parse_validArgs_success() {
        assertParseSuccess(parser, VALID_TAG_HUSBAND,
                new AddAllTagCommand(new Tag(VALID_TAG_HUSBAND)));
    }

    @Test
    public void parse_invalidTag_failure() {
        // non-alphanumeric
        assertParseFailure(parser, "#hashtag",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddAllTagCommand.MESSAGE_USAGE));

        // whitespace
        assertParseFailure(parser, "good guy",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddAllTagCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidFormat_failure() {
        // No arguments
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddAllTagCommand.MESSAGE_USAGE));
    }

}
