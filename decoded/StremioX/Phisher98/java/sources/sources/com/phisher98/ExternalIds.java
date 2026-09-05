package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ExternalIds;", "", "imdb_id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "tvdb_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getImdb_id", "()Ljava/lang/String;", "getTvdb_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ExternalIds {

    @Nullable
    private final String imdb_id;

    @Nullable
    private final String tvdb_id;

    /* JADX WARN: Illegal instructions before constructor call */
    public ExternalIds() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ ExternalIds copy$default(ExternalIds externalIds, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = externalIds.imdb_id;
        }
        if ((i & 2) != 0) {
            str2 = externalIds.tvdb_id;
        }
        return externalIds.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTvdb_id() {
        return this.tvdb_id;
    }

    @NotNull
    public final ExternalIds copy(@JsonProperty("imdb_id") @Nullable String imdb_id, @JsonProperty("tvdb_id") @Nullable String tvdb_id) {
        return new ExternalIds(imdb_id, tvdb_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalIds)) {
            return false;
        }
        ExternalIds externalIds = (ExternalIds) other;
        return Intrinsics.areEqual(this.imdb_id, externalIds.imdb_id) && Intrinsics.areEqual(this.tvdb_id, externalIds.tvdb_id);
    }

    public int hashCode() {
        return ((this.imdb_id == null ? 0 : this.imdb_id.hashCode()) * 31) + (this.tvdb_id != null ? this.tvdb_id.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ExternalIds(imdb_id=" + this.imdb_id + ", tvdb_id=" + this.tvdb_id + ')';
    }

    public ExternalIds(@JsonProperty("imdb_id") @Nullable String imdb_id, @JsonProperty("tvdb_id") @Nullable String tvdb_id) {
        this.imdb_id = imdb_id;
        this.tvdb_id = tvdb_id;
    }

    public /* synthetic */ ExternalIds(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getImdb_id() {
        return this.imdb_id;
    }

    @Nullable
    public final String getTvdb_id() {
        return this.tvdb_id;
    }
}
