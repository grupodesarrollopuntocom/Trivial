package org.pmm.trivial;

public class Question {

	String subject;
	String questionText;
	String[] answers;
	int rightAnswer;
	int help;
	
	public Question(String subject, String question, String answers[], int validAnswer, int help){
		this.subject = subject;
		this.questionText = question;
		this.answers = answers;
		this.rightAnswer = validAnswer;
		this.help = help;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	
	public int getRightAnswer() {
		return rightAnswer;
	}
	
	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	public int getHelp() {
		return help;
	}
	
	public void setHelp(int help) {
		this.help = help;
	}
}
