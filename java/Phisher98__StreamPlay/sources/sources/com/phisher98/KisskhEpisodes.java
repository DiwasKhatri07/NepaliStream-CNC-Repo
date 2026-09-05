package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJB\u0010\u000f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/phisher98/KisskhEpisodes;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "number", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumber", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/KisskhEpisodes;", "equals", "", "other", "hashCode", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class KisskhEpisodes {

    @Nullable
    private final Integer id;

    @Nullable
    private final Integer number;

    public static /* synthetic */ KisskhEpisodes copy$default(KisskhEpisodes kisskhEpisodes, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = kisskhEpisodes.id;
        }
        if ((i & 2) != 0) {
            num2 = kisskhEpisodes.number;
        }
        return kisskhEpisodes.copy(num, num2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getNumber() {
        return this.number;
    }

    @NotNull
    public final KisskhEpisodes copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("number") @Nullable Integer number) {
        return new KisskhEpisodes(id, number);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KisskhEpisodes)) {
            return false;
        }
        KisskhEpisodes kisskhEpisodes = (KisskhEpisodes) other;
        return Intrinsics.areEqual(this.id, kisskhEpisodes.id) && Intrinsics.areEqual(this.number, kisskhEpisodes.number);
    }

    public int hashCode() {
        return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.number != null ? this.number.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "KisskhEpisodes(id=" + this.id + ", number=" + this.number + ')';
    }

    public KisskhEpisodes(@JsonProperty("id") @Nullable Integer id, @JsonProperty("number") @Nullable Integer number) {
        this.id = id;
        this.number = number;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final Integer getNumber() {
        return this.number;
    }
}
