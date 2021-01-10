package org.heartfulness.subscription;

import org.springframework.data.repository.Repository;

public interface SubscriptionRepository extends Repository<Subscription, Integer> {

    Subscription save(Subscription subscription);
}
