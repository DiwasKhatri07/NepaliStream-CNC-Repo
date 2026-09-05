package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/KisskhResults;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/KisskhResults;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class KisskhResults {

    @Nullable
    private final Integer id;

    @Nullable
    private final String title;

    public static /* synthetic */ KisskhResults copy$default(KisskhResults kisskhResults, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = kisskhResults.id;
        }
        if ((i & 2) != 0) {
            str = kisskhResults.title;
        }
        return kisskhResults.copy(num, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final KisskhResults copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title) {
        return new KisskhResults(id, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KisskhResults)) {
            return false;
        }
        KisskhResults kisskhResults = (KisskhResults) other;
        return Intrinsics.areEqual(this.id, kisskhResults.id) && Intrinsics.areEqual(this.title, kisskhResults.title);
    }

    public int hashCode() {
        return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title != null ? this.title.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "KisskhResults(id=" + this.id + ", title=" + this.title + ')';
    }

    public KisskhResults(@JsonProperty("id") @Nullable Integer id, @JsonProperty("title") @Nullable String title) {
        this.id = id;
        this.title = title;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
