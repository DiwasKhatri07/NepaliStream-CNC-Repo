package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003JB\u0010\u0013\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\bHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR'\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001a"}, d2 = {"Lcom/AniVortex/OttPageInfo;", "", "hasMore", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "has_more", "nextCursor", "", "next_cursor", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNextCursor", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/AniVortex/OttPageInfo;", "equals", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class OttPageInfo {

    @JsonProperty("has_more")
    @Nullable
    private final Boolean hasMore;

    @JsonProperty("next_cursor")
    @Nullable
    private final String nextCursor;

    /* JADX WARN: Multi-variable type inference failed */
    public OttPageInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OttPageInfo copy$default(OttPageInfo ottPageInfo, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = ottPageInfo.hasMore;
        }
        if ((i & 2) != 0) {
            str = ottPageInfo.nextCursor;
        }
        return ottPageInfo.copy(bool, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNextCursor() {
        return this.nextCursor;
    }

    @NotNull
    public final OttPageInfo copy(@JsonProperty("has_more") @Nullable Boolean hasMore, @JsonProperty("next_cursor") @Nullable String nextCursor) {
        return new OttPageInfo(hasMore, nextCursor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OttPageInfo)) {
            return false;
        }
        OttPageInfo ottPageInfo = (OttPageInfo) other;
        return Intrinsics.areEqual(this.hasMore, ottPageInfo.hasMore) && Intrinsics.areEqual(this.nextCursor, ottPageInfo.nextCursor);
    }

    public int hashCode() {
        return ((this.hasMore == null ? 0 : this.hasMore.hashCode()) * 31) + (this.nextCursor != null ? this.nextCursor.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OttPageInfo(hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ')';
    }

    public OttPageInfo(@JsonProperty("has_more") @Nullable Boolean hasMore, @JsonProperty("next_cursor") @Nullable String nextCursor) {
        this.hasMore = hasMore;
        this.nextCursor = nextCursor;
    }

    public /* synthetic */ OttPageInfo(Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str);
    }

    @Nullable
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public final String getNextCursor() {
        return this.nextCursor;
    }
}
