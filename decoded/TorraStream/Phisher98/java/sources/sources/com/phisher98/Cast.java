package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004R%\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR#\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R#\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R#\u0010\b\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R#\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006'"}, d2 = {"Lcom/phisher98/Cast;", "", "id", "", "name", "", "originalName", "character", "knownForDepartment", "profilePath", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getName", "()Ljava/lang/String;", "getOriginalName", "original_name", "getCharacter", "getKnownForDepartment", "known_for_department", "getProfilePath", "profile_path", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/Cast;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Cast {

    @Nullable
    private final String character;

    @Nullable
    private final Integer id;

    @Nullable
    private final String knownForDepartment;

    @Nullable
    private final String name;

    @Nullable
    private final String originalName;

    @Nullable
    private final String profilePath;

    public Cast() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Cast copy$default(Cast cast, Integer num, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            num = cast.id;
        }
        if ((i & 2) != 0) {
            str = cast.name;
        }
        if ((i & 4) != 0) {
            str2 = cast.originalName;
        }
        if ((i & 8) != 0) {
            str3 = cast.character;
        }
        if ((i & 16) != 0) {
            str4 = cast.knownForDepartment;
        }
        if ((i & 32) != 0) {
            str5 = cast.profilePath;
        }
        String str6 = str4;
        String str7 = str5;
        return cast.copy(num, str, str2, str3, str6, str7);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOriginalName() {
        return this.originalName;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCharacter() {
        return this.character;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getKnownForDepartment() {
        return this.knownForDepartment;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getProfilePath() {
        return this.profilePath;
    }

    @NotNull
    public final Cast copy(@Nullable Integer id, @Nullable String name, @Nullable String originalName, @Nullable String character, @Nullable String knownForDepartment, @Nullable String profilePath) {
        return new Cast(id, name, originalName, character, knownForDepartment, profilePath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cast)) {
            return false;
        }
        Cast cast = (Cast) other;
        return Intrinsics.areEqual(this.id, cast.id) && Intrinsics.areEqual(this.name, cast.name) && Intrinsics.areEqual(this.originalName, cast.originalName) && Intrinsics.areEqual(this.character, cast.character) && Intrinsics.areEqual(this.knownForDepartment, cast.knownForDepartment) && Intrinsics.areEqual(this.profilePath, cast.profilePath);
    }

    public int hashCode() {
        return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.knownForDepartment == null ? 0 : this.knownForDepartment.hashCode())) * 31) + (this.profilePath != null ? this.profilePath.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Cast(id=" + this.id + ", name=" + this.name + ", originalName=" + this.originalName + ", character=" + this.character + ", knownForDepartment=" + this.knownForDepartment + ", profilePath=" + this.profilePath + ')';
    }

    public Cast(@Nullable Integer id, @Nullable String name, @Nullable String originalName, @Nullable String character, @Nullable String knownForDepartment, @Nullable String profilePath) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.character = character;
        this.knownForDepartment = knownForDepartment;
        this.profilePath = profilePath;
    }

    public /* synthetic */ Cast(Integer num, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    @JsonProperty("id")
    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @JsonProperty("name")
    @Nullable
    public final String getName() {
        return this.name;
    }

    @JsonProperty("original_name")
    @Nullable
    public final String getOriginalName() {
        return this.originalName;
    }

    @JsonProperty("character")
    @Nullable
    public final String getCharacter() {
        return this.character;
    }

    @JsonProperty("known_for_department")
    @Nullable
    public final String getKnownForDepartment() {
        return this.knownForDepartment;
    }

    @JsonProperty("profile_path")
    @Nullable
    public final String getProfilePath() {
        return this.profilePath;
    }
}
