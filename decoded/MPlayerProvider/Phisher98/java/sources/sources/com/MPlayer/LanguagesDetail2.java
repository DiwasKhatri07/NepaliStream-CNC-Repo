package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/MPlayer/LanguagesDetail2;", "", "id", "", "name", "webUrl", "threeCharLanguageId", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "three_char_language_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getWebUrl", "getThreeCharLanguageId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LanguagesDetail2 {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String threeCharLanguageId;

    @NotNull
    private final String webUrl;

    public static /* synthetic */ LanguagesDetail2 copy$default(LanguagesDetail2 languagesDetail2, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = languagesDetail2.id;
        }
        if ((i & 2) != 0) {
            str2 = languagesDetail2.name;
        }
        if ((i & 4) != 0) {
            str3 = languagesDetail2.webUrl;
        }
        if ((i & 8) != 0) {
            str4 = languagesDetail2.threeCharLanguageId;
        }
        return languagesDetail2.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWebUrl() {
        return this.webUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getThreeCharLanguageId() {
        return this.threeCharLanguageId;
    }

    @NotNull
    public final LanguagesDetail2 copy(@NotNull String id, @NotNull String name, @NotNull String webUrl, @JsonProperty("three_char_language_id") @NotNull String threeCharLanguageId) {
        return new LanguagesDetail2(id, name, webUrl, threeCharLanguageId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguagesDetail2)) {
            return false;
        }
        LanguagesDetail2 languagesDetail2 = (LanguagesDetail2) other;
        return Intrinsics.areEqual(this.id, languagesDetail2.id) && Intrinsics.areEqual(this.name, languagesDetail2.name) && Intrinsics.areEqual(this.webUrl, languagesDetail2.webUrl) && Intrinsics.areEqual(this.threeCharLanguageId, languagesDetail2.threeCharLanguageId);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.webUrl.hashCode()) * 31) + this.threeCharLanguageId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LanguagesDetail2(id=" + this.id + ", name=" + this.name + ", webUrl=" + this.webUrl + ", threeCharLanguageId=" + this.threeCharLanguageId + ')';
    }

    public LanguagesDetail2(@NotNull String id, @NotNull String name, @NotNull String webUrl, @JsonProperty("three_char_language_id") @NotNull String threeCharLanguageId) {
        this.id = id;
        this.name = name;
        this.webUrl = webUrl;
        this.threeCharLanguageId = threeCharLanguageId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getWebUrl() {
        return this.webUrl;
    }

    @NotNull
    public final String getThreeCharLanguageId() {
        return this.threeCharLanguageId;
    }
}
