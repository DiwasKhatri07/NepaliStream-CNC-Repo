package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JQ\u0010\u0014\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/phisher98/Person;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Name", "role", "Role", "type", "Type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getRole", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Person {

    @NotNull
    private final String name;

    @NotNull
    private final String role;

    @NotNull
    private final String type;

    public static /* synthetic */ Person copy$default(Person person, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = person.name;
        }
        if ((i & 2) != 0) {
            str2 = person.role;
        }
        if ((i & 4) != 0) {
            str3 = person.type;
        }
        return person.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final Person copy(@JsonProperty("Name") @NotNull String name, @JsonProperty("Role") @NotNull String role, @JsonProperty("Type") @NotNull String type) {
        return new Person(name, role, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Person)) {
            return false;
        }
        Person person = (Person) other;
        return Intrinsics.areEqual(this.name, person.name) && Intrinsics.areEqual(this.role, person.role) && Intrinsics.areEqual(this.type, person.type);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.role.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "Person(name=" + this.name + ", role=" + this.role + ", type=" + this.type + ')';
    }

    public Person(@JsonProperty("Name") @NotNull String name, @JsonProperty("Role") @NotNull String role, @JsonProperty("Type") @NotNull String type) {
        this.name = name;
        this.role = role;
        this.type = type;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRole() {
        return this.role;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
