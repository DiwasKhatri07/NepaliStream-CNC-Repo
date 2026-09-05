package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/SuperStream/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/phisher98/PersonalComments;", "", "code", "", "file", "Lcom/phisher98/FileData;", "html2", "", "id", "<init>", "(ILcom/phisher98/FileData;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getFile", "()Lcom/phisher98/FileData;", "getHtml2", "()Ljava/lang/String;", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PersonalComments {
    private final int code;

    @Nullable
    private final FileData file;

    @Nullable
    private final String html2;

    @Nullable
    private final String id;

    public static /* synthetic */ PersonalComments copy$default(PersonalComments personalComments, int i, FileData fileData, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = personalComments.code;
        }
        if ((i2 & 2) != 0) {
            fileData = personalComments.file;
        }
        if ((i2 & 4) != 0) {
            str = personalComments.html2;
        }
        if ((i2 & 8) != 0) {
            str2 = personalComments.id;
        }
        return personalComments.copy(i, fileData, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FileData getFile() {
        return this.file;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHtml2() {
        return this.html2;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final PersonalComments copy(int code, @Nullable FileData file, @Nullable String html2, @Nullable String id) {
        return new PersonalComments(code, file, html2, id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonalComments)) {
            return false;
        }
        PersonalComments personalComments = (PersonalComments) other;
        return this.code == personalComments.code && Intrinsics.areEqual(this.file, personalComments.file) && Intrinsics.areEqual(this.html2, personalComments.html2) && Intrinsics.areEqual(this.id, personalComments.id);
    }

    public int hashCode() {
        return (((((this.code * 31) + (this.file == null ? 0 : this.file.hashCode())) * 31) + (this.html2 == null ? 0 : this.html2.hashCode())) * 31) + (this.id != null ? this.id.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PersonalComments(code=" + this.code + ", file=" + this.file + ", html2=" + this.html2 + ", id=" + this.id + ')';
    }

    public PersonalComments(int code, @Nullable FileData file, @Nullable String html2, @Nullable String id) {
        this.code = code;
        this.file = file;
        this.html2 = html2;
        this.id = id;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final FileData getFile() {
        return this.file;
    }

    @Nullable
    public final String getHtml2() {
        return this.html2;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }
}
