
public class PhoneInfo implements Comparable<PhoneInfo> {

	private String name ;
	private String Phonenumber ;
	public PhoneInfo(String name, String phonenumber) {
		super();
		this.name = name;
		Phonenumber = phonenumber;
	}
	public PhoneInfo() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}
@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", Phonenumber=" + Phonenumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Phonenumber == null) ? 0 : Phonenumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneInfo other = (PhoneInfo) obj;
		if (Phonenumber == null) {
			if (other.Phonenumber != null)
				return false;
		} else if (!Phonenumber.equals(other.Phonenumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
@Override
	public int compareTo(PhoneInfo o) {
	if(this.name.equals(o.getName())==true){
		return this.Phonenumber.compareTo(o.Phonenumber) ;
	}
	else{
		return this.name.compareTo(o.getName()) ;
	}
	}

 
	
}



