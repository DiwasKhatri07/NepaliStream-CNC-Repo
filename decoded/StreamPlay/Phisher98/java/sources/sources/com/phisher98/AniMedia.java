package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJB\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/phisher98/AniMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "idMal", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIdMal", "setIdMal", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/AniMedia;", "equals", "", "other", "hashCode", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AniMedia {

    @Nullable
    private Integer id;

    @Nullable
    private Integer idMal;

    /* JADX WARN: Illegal instructions before constructor call */
    public AniMedia() {
        Integer num = null;
        this(num, num, 3, num);
    }

    public static /* synthetic */ AniMedia copy$default(AniMedia aniMedia, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = aniMedia.id;
        }
        if ((i & 2) != 0) {
            num2 = aniMedia.idMal;
        }
        return aniMedia.copy(num, num2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getIdMal() {
        return this.idMal;
    }

    @NotNull
    public final AniMedia copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("idMal") @Nullable Integer idMal) {
        return new AniMedia(id, idMal);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AniMedia)) {
            return false;
        }
        AniMedia aniMedia = (AniMedia) other;
        return Intrinsics.areEqual(this.id, aniMedia.id) && Intrinsics.areEqual(this.idMal, aniMedia.idMal);
    }

    public int hashCode() {
        return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.idMal != null ? this.idMal.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AniMedia(id=" + this.id + ", idMal=" + this.idMal + ')';
    }

    public AniMedia(@JsonProperty("id") @Nullable Integer id, @JsonProperty("idMal") @Nullable Integer idMal) {
        this.id = id;
        this.idMal = idMal;
    }

    public /* synthetic */ AniMedia(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    public final void setId(@Nullable Integer num) {
        this.id = num;
    }

    @Nullable
    public final Integer getIdMal() {
        return this.idMal;
    }

    public final void setIdMal(@Nullable Integer num) {
        this.idMal = num;
    }
}
