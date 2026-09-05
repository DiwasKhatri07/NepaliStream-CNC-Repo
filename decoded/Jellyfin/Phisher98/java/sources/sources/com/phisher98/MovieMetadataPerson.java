package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u009d\u0001\u0010\"\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011HÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/phisher98/MovieMetadataPerson;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Name", "id", "Id", "role", "Role", "type", "Type", "primaryImageTag", "PrimaryImageTag", "imageBlurHashes", "Lcom/phisher98/ImageBlurHashesWrapper;", "ImageBlurHashes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/ImageBlurHashesWrapper;)V", "getName", "()Ljava/lang/String;", "getId", "getRole", "getType", "getPrimaryImageTag", "getImageBlurHashes", "()Lcom/phisher98/ImageBlurHashesWrapper;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieMetadataPerson {

    @NotNull
    private final String id;

    @Nullable
    private final ImageBlurHashesWrapper imageBlurHashes;

    @NotNull
    private final String name;

    @Nullable
    private final String primaryImageTag;

    @NotNull
    private final String role;

    @NotNull
    private final String type;

    public static /* synthetic */ MovieMetadataPerson copy$default(MovieMetadataPerson movieMetadataPerson, String str, String str2, String str3, String str4, String str5, ImageBlurHashesWrapper imageBlurHashesWrapper, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieMetadataPerson.name;
        }
        if ((i & 2) != 0) {
            str2 = movieMetadataPerson.id;
        }
        if ((i & 4) != 0) {
            str3 = movieMetadataPerson.role;
        }
        if ((i & 8) != 0) {
            str4 = movieMetadataPerson.type;
        }
        if ((i & 16) != 0) {
            str5 = movieMetadataPerson.primaryImageTag;
        }
        if ((i & 32) != 0) {
            imageBlurHashesWrapper = movieMetadataPerson.imageBlurHashes;
        }
        String str6 = str5;
        ImageBlurHashesWrapper imageBlurHashesWrapper2 = imageBlurHashesWrapper;
        return movieMetadataPerson.copy(str, str2, str3, str4, str6, imageBlurHashesWrapper2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrimaryImageTag() {
        return this.primaryImageTag;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ImageBlurHashesWrapper getImageBlurHashes() {
        return this.imageBlurHashes;
    }

    @NotNull
    public final MovieMetadataPerson copy(@JsonProperty("Name") @NotNull String name, @JsonProperty("Id") @NotNull String id, @JsonProperty("Role") @NotNull String role, @JsonProperty("Type") @NotNull String type, @JsonProperty("PrimaryImageTag") @Nullable String primaryImageTag, @JsonProperty("ImageBlurHashes") @Nullable ImageBlurHashesWrapper imageBlurHashes) {
        return new MovieMetadataPerson(name, id, role, type, primaryImageTag, imageBlurHashes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieMetadataPerson)) {
            return false;
        }
        MovieMetadataPerson movieMetadataPerson = (MovieMetadataPerson) other;
        return Intrinsics.areEqual(this.name, movieMetadataPerson.name) && Intrinsics.areEqual(this.id, movieMetadataPerson.id) && Intrinsics.areEqual(this.role, movieMetadataPerson.role) && Intrinsics.areEqual(this.type, movieMetadataPerson.type) && Intrinsics.areEqual(this.primaryImageTag, movieMetadataPerson.primaryImageTag) && Intrinsics.areEqual(this.imageBlurHashes, movieMetadataPerson.imageBlurHashes);
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + this.role.hashCode()) * 31) + this.type.hashCode()) * 31) + (this.primaryImageTag == null ? 0 : this.primaryImageTag.hashCode())) * 31) + (this.imageBlurHashes != null ? this.imageBlurHashes.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MovieMetadataPerson(name=" + this.name + ", id=" + this.id + ", role=" + this.role + ", type=" + this.type + ", primaryImageTag=" + this.primaryImageTag + ", imageBlurHashes=" + this.imageBlurHashes + ')';
    }

    public MovieMetadataPerson(@JsonProperty("Name") @NotNull String name, @JsonProperty("Id") @NotNull String id, @JsonProperty("Role") @NotNull String role, @JsonProperty("Type") @NotNull String type, @JsonProperty("PrimaryImageTag") @Nullable String primaryImageTag, @JsonProperty("ImageBlurHashes") @Nullable ImageBlurHashesWrapper imageBlurHashes) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.type = type;
        this.primaryImageTag = primaryImageTag;
        this.imageBlurHashes = imageBlurHashes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MovieMetadataPerson(String str, String str2, String str3, String str4, String str5, ImageBlurHashesWrapper imageBlurHashesWrapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ImageBlurHashesWrapper imageBlurHashesWrapper2;
        str5 = (i & 16) != 0 ? null : str5;
        if ((i & 32) == 0) {
            imageBlurHashesWrapper2 = imageBlurHashesWrapper;
        } else {
            imageBlurHashesWrapper2 = null;
        }
        this(str, str2, str3, str4, str5, imageBlurHashesWrapper2);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getRole() {
        return this.role;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getPrimaryImageTag() {
        return this.primaryImageTag;
    }

    @Nullable
    public final ImageBlurHashesWrapper getImageBlurHashes() {
        return this.imageBlurHashes;
    }
}
