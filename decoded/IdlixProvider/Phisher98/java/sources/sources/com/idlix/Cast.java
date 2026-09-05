package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IdlixProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/idlix/Cast;", "", "id", "", "name", "character", "profilePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCharacter", "getProfilePath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Cast {

    @Nullable
    private final String character;

    @Nullable
    private final String id;

    @Nullable
    private final String name;

    @Nullable
    private final String profilePath;

    public Cast() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Cast copy$default(Cast cast, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cast.id;
        }
        if ((i & 2) != 0) {
            str2 = cast.name;
        }
        if ((i & 4) != 0) {
            str3 = cast.character;
        }
        if ((i & 8) != 0) {
            str4 = cast.profilePath;
        }
        return cast.copy(str, str2, str3, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCharacter() {
        return this.character;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getProfilePath() {
        return this.profilePath;
    }

    @NotNull
    public final Cast copy(@Nullable String id, @Nullable String name, @Nullable String character, @Nullable String profilePath) {
        return new Cast(id, name, character, profilePath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cast)) {
            return false;
        }
        Cast cast = (Cast) other;
        return Intrinsics.areEqual(this.id, cast.id) && Intrinsics.areEqual(this.name, cast.name) && Intrinsics.areEqual(this.character, cast.character) && Intrinsics.areEqual(this.profilePath, cast.profilePath);
    }

    public int hashCode() {
        return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.profilePath != null ? this.profilePath.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Cast(id=" + this.id + ", name=" + this.name + ", character=" + this.character + ", profilePath=" + this.profilePath + ')';
    }

    public Cast(@Nullable String id, @Nullable String name, @Nullable String character, @Nullable String profilePath) {
        this.id = id;
        this.name = name;
        this.character = character;
        this.profilePath = profilePath;
    }

    public /* synthetic */ Cast(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getCharacter() {
        return this.character;
    }

    @Nullable
    public final String getProfilePath() {
        return this.profilePath;
    }
}
