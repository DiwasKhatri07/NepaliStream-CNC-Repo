package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R#\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR#\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/phisher98/AltTitles;", "", "iso_3166_1", "", "title", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIso_3166_1", "()Ljava/lang/String;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getTitle", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AltTitles {

    @Nullable
    private final String iso_3166_1;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    public AltTitles() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AltTitles copy$default(AltTitles altTitles, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = altTitles.iso_3166_1;
        }
        if ((i & 2) != 0) {
            str2 = altTitles.title;
        }
        if ((i & 4) != 0) {
            str3 = altTitles.type;
        }
        return altTitles.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIso_3166_1() {
        return this.iso_3166_1;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final AltTitles copy(@Nullable String iso_3166_1, @Nullable String title, @Nullable String type) {
        return new AltTitles(iso_3166_1, title, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AltTitles)) {
            return false;
        }
        AltTitles altTitles = (AltTitles) other;
        return Intrinsics.areEqual(this.iso_3166_1, altTitles.iso_3166_1) && Intrinsics.areEqual(this.title, altTitles.title) && Intrinsics.areEqual(this.type, altTitles.type);
    }

    public int hashCode() {
        return ((((this.iso_3166_1 == null ? 0 : this.iso_3166_1.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AltTitles(iso_3166_1=" + this.iso_3166_1 + ", title=" + this.title + ", type=" + this.type + ')';
    }

    public AltTitles(@Nullable String iso_3166_1, @Nullable String title, @Nullable String type) {
        this.iso_3166_1 = iso_3166_1;
        this.title = title;
        this.type = type;
    }

    public /* synthetic */ AltTitles(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JsonProperty("iso_3166_1")
    @Nullable
    public final String getIso_3166_1() {
        return this.iso_3166_1;
    }

    @JsonProperty("title")
    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @JsonProperty("type")
    @Nullable
    public final String getType() {
        return this.type;
    }
}
