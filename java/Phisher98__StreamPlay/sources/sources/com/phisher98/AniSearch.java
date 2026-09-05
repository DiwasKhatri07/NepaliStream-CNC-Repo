package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/phisher98/AniSearch;", "", "data", "Lcom/phisher98/AniData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/AniData;)V", "getData", "()Lcom/phisher98/AniData;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AniSearch {

    @Nullable
    private AniData data;

    /* JADX WARN: Illegal instructions before constructor call */
    public AniSearch() {
        AniData aniData = null;
        this(aniData, 1, aniData);
    }

    public static /* synthetic */ AniSearch copy$default(AniSearch aniSearch, AniData aniData, int i, Object obj) {
        if ((i & 1) != 0) {
            aniData = aniSearch.data;
        }
        return aniSearch.copy(aniData);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AniData getData() {
        return this.data;
    }

    @NotNull
    public final AniSearch copy(@JsonProperty("data") @Nullable AniData data) {
        return new AniSearch(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AniSearch) && Intrinsics.areEqual(this.data, ((AniSearch) other).data);
    }

    public int hashCode() {
        if (this.data == null) {
            return 0;
        }
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "AniSearch(data=" + this.data + ')';
    }

    public AniSearch(@JsonProperty("data") @Nullable AniData data) {
        this.data = data;
    }

    public /* synthetic */ AniSearch(AniData aniData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aniData);
    }

    @Nullable
    public final AniData getData() {
        return this.data;
    }

    public final void setData(@Nullable AniData aniData) {
        this.data = aniData;
    }
}
